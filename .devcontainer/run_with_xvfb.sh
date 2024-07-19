#!/bin/bash

# Update and install necessary libraries
sudo apt-get update
sudo apt-get install -y xvfb x11vnc openbox

# Create /tmp/.X11-unix directory with correct permissions
sudo mkdir -p /tmp/.X11-unix
sudo chmod 1777 /tmp/.X11-unix
sudo chown root:root /tmp/.X11-unix

# Kill any existing Xvfb processes
pkill -f "Xvfb :99" || true

# Remove the lock file if it exists
sudo rm -f /tmp/.X99-lock

# Start Xvfb and set DISPLAY environment variable
Xvfb :99 -screen 0 1024x768x24 &
XVFB_PID=$!
export DISPLAY=:99

# Start x11vnc without a password
x11vnc -display :99 -nopw -forever -bg -o /tmp/x11vnc.log &

# Start openbox window manager
openbox-session &

# Wait a moment to ensure Xvfb has started
sleep 2

# Verify DISPLAY is set
echo "DISPLAY is set to $DISPLAY"

# Change to the root directory of the project
cd /workspaces/$(basename $PWD)

# Ensure gradlew has executable permissions
if [ -f ./gradlew ]; then
    chmod +x ./gradlew
else
    echo "gradlew script not found."
    exit 1
fi

# Clean the project
./gradlew clean

# Build the project
./gradlew build

# Verify the JAR file location
JAR_FILE=$(ls build/libs/*.jar | head -n 1)
if [ -z "$JAR_FILE" ]; then
    echo "JAR file not found. Build might have failed."
    exit 1
fi

# Run the Java application with the added JVM option
JAVA_BIN="/home/codespace/java/current/bin/java"
if [ -f "$JAVA_BIN" ]; then
    /usr/bin/env DISPLAY=:99 "$JAVA_BIN" -Dsun.java2d.xrender=false -jar "$JAR_FILE"
else
    echo "Java binary not found at $JAVA_BIN."
    exit 1
fi

# Trap to ensure Xvfb and x11vnc shut down gracefully
trap "echo 'Stopping Xvfb and x11vnc'; kill $XVFB_PID; pkill -f x11vnc" EXIT

# Keep the script running to maintain the X session
wait $XVFB_PID

#!/bin/bash

# Create /tmp/.X11-unix directory with correct permissions
mkdir -p /tmp/.X11-unix
chmod 1777 /tmp/.X11-unix
chown root:root /tmp/.X11-unix

# Kill any existing Xvfb processes
pkill -f "Xvfb :99" || true

# Remove the lock file if it exists
rm -f /tmp/.X99-lock

# Start Xvfb and set DISPLAY environment variable
Xvfb :99 -screen 0 1024x768x24 &
XVFB_PID=$!
export DISPLAY=:99

# Start x11vnc without a password on port 5900
x11vnc -display :99 -nopw -forever -rfbport 5900 -bg -o /tmp/x11vnc.log -noxdamage -noxfixes -noxkb -nolookup -no6 -shared &

# Start openbox window manager
openbox-session &

# Start noVNC
websockify --web=/usr/share/novnc/ --wrap-mode=ignore 6080 localhost:5900 &

# Wait a moment to ensure Xvfb has started
sleep 2

# Verify DISPLAY is set
echo "DISPLAY is set to $DISPLAY"

# Change to the root directory of the project
cd /workspaces/Group-Z || exit

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

# Run your .sh script
/usr/bin/env DISPLAY=:99 /path/to/your-script.sh &

# Trap to ensure Xvfb and x11vnc shut down gracefully
trap "echo 'Stopping Xvfb and x11vnc'; kill $XVFB_PID; pkill -f x11vnc" EXIT

# Keep the script running to maintain the X session
wait $XVFB_PID

# Variables
APP_NAME=bank-app
PORT=8080

# Build Docker image
build:
	docker build --platform=linux/amd64 -t $(APP_NAME) .

# Run Docker container
run:
	docker run -p $(PORT):8080 $(APP_NAME)

# Clean Docker stuff (optional)
clean:
	docker rmi -f $(APP_NAME) || true

# Rebuild fresh
rebuild: clean build run

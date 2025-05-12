APP_NAME=bank-app
PORT=8080

build:
	mvn clean package
	docker build -t $(APP_NAME) .

run:
	docker run -p $(PORT):8080 $(APP_NAME)

clean:
	docker rmi -f $(APP_NAME) || true

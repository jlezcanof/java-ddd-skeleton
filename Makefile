.PHONY: all
all: build

.PHONY: up
up:
	@docker-compose up -d

.PHONY: down
down:
	@docker-compose down

.PHONY: build
build:
	@./gradlew build -x test --warning-mode all

.PHONY: run-tests
run-tests:
	@./gradlew test --warning-mode all

.PHONY: test
test:
	@docker exec codelytv-ddd_skeleton-java ./gradlew test --warning-mode all

.PHONY: test-i
test-i:
	@docker exec codelytv-ddd_skeleton-java ./gradlew test -i

.PHONY: test-scan
test-scan:
	@docker exec codelytv-ddd_skeleton-java ./gradlew test -i --scan

#.PHONY: run
#run:
#	@./gradlew :run
# no funciona porque necesita run no es reconocido para esta version y ademas necesita 2 argumentos

.PHONY: ping-mysql
ping-mysql:
	@docker exec codelytv-java_ddd_skeleton-mysql mysqladmin --user=root --password= --host "127.0.0.1" ping --silent

# Start the app
.PHONY: start-mooc_backend
start-mooc_backend:
	@./gradlew :bootRun --args='mooc_backend server'

.PHONY: start-backoffice_backend
start-backoffice_backend:
	@./gradlew :bootRun --args='backoffice_backend server'

.PHONY: start-backoffice_frontend
start-backoffice_frontend:
	@./gradlew :bootRun --args='backoffice_frontend server'

.PHONY: start-mooc_backend_api
start-mooc_backend_api:
	@./gradlew :bootRun --args='mooc_backend api'

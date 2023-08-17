pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw install'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .'
            }
        }
    }
}
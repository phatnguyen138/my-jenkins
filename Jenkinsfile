pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
                sh './mvnw install'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo .'
                sh 'docker push phatnguyen1812/my-first-repo'
            }
        }
    }
}
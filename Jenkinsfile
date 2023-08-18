pipeline {
    agent {
        docker {
            image 'node:18.17.1-alpine3.18'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh './mvnw install'
            }
        }
        stage('Docker Build') {
            steps {
                withDockerRegistry(credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/'){
                    sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo .'
                    sh 'docker push phatnguyen1812/my-first-repo'
                }
            }
        }
    }
}

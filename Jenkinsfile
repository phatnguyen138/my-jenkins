pipeline {
    agent any
    tools {
        maven 'my-maven'
        jdk 'jdk-17'
    }
    stages {
        stage('Build') {
            steps {
                sh './mvnw install'
                sh 'ls'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'ls'
                withDockerRegistry(credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/'){
                    sh 'echo "Build"'
                    sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo --progress=plain .'
                    sh 'docker push phatnguyen1812/my-first-repo'
                    sh 'echo "Push"'
                }
            }
        }
    }
}

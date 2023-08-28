pipeline {
    agent any
    tools {
        jdk 'jdk-17'
        maven 'my-maven'
    }
    stages {
        stage('Build') {
            steps {
                sh './mvnw install'
                sh 'ls'
            }
        }
        stage('Test'){
            steps{
                sh 'java -version'
            }
        }
        stage('Docker Build') {
            steps {
                withDockerRegistry(credentialsId: 'dockerid', url: 'https://index.docker.io/v1/'){
                    sh 'echo "Build"'
                    sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo --progress=plain .'
                    sh 'docker push phatnguyen1812/my-first-repo'
                    sh 'echo "Push"'
                }
                catchError {
                    // Handle the error here
                    echo "An error occurred: ${it}"
                }
            }
        }
    }
}

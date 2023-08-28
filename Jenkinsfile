pipeline {
    agent any
    tools {
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
        // stage('Docker Build') {
        //     steps {
        //         sh 'ls'
        //         sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo --progress=plain .'
        //         // withDockerRegistry(credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/'){
        //         //     sh 'echo "Build"'
        //         //     sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo --progress=plain .'
        //         //     sh 'docker push phatnguyen1812/my-first-repo'
        //         //     sh 'echo "Push"'
        //         // }
        //         // catchError {
        //         //     // Handle the error here
        //         //     echo "An error occurred: ${it}"
        //         // }
        //     }
        // }
    }
}

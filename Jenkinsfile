pipeline {
    agent any
    tools {
        jdk 'jdk-17'
        maven 'my-maven'
    }
    stages {
        stage('Build jar file') {
            steps {
                sh './mvnw install'
                sh 'ls'
            }
        }
        
        stage('Code scanning with sonarqube'){
            when {
                branch 'dev'
            }
            steps{
                withSonarQubeEnv("my-sonar"){
                    sh 'mvn -version'
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
        stage('Build and deploy Docker image') {
            steps {
                withDockerRegistry(credentialsId: 'dockerid', url: 'https://index.docker.io/v1/'){
                    sh 'echo "Build"'
                    sh 'docker build --build-arg JAR_FILE=target/*.jar -t phatnguyen1812/my-first-repo --progress=plain .'
                    sh 'docker push phatnguyen1812/my-first-repo'
                    sh 'echo "Push"'
                }
                catchError {
                    // Handle the error
                    echo "An error occurred: ${it}"
                }
            }
        }
        stage('Deploy into remote server') {
            steps {
                sh 'echo "Deploy!"'
                script {
                    def remoteServerIp = '192.168.1.84'  // Replace with your VM's IP address
                    def remoteUsername = 'phat'
                    
                    sshagent(credentials: ['ssh-key']) {
                        sh 'ssh phat@192.168.1.84 "docker pull phatnguyen1812/my-first-repo && docker run -d --rm -p 8081:8080 phatnguyen1812/my-first-repo"'
                    }
                }
            }
        }
    }
}

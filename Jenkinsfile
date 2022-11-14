pipeline {
    agent any

    stages {
        stage('git') {
            steps {
                git branch: 'moemen2', credentialsId: '9154784c-eb82-4f58-9606-8fd50e25cf28', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git'
            }
        }
        
        stage('MavenClean') {
            steps {
               sh 'mvn clean'
            }
        }
        stage('MavenTEST') {
            steps {
                sh 'mvn test ';
            }
        }
        stage('MavenCompile') {
            steps {
               sh 'mvn compile'
            }
        }
        stage('MavenDeploy') {
            steps {
                sh 'mvn clean deploy -Dmaven.test.skip=true';
            }
        }
        stage('Maven SonarQube') {
            steps {
               sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=root'
            }
        }

        stage("Push fe-i to DockerHub") {
            steps{
                // login to docker hub
                sh 'docker login -u abdelmoementrabelsi -p viscabarca123'
                
                // build & push angular image to docker hub
                sh 'docker build -t abdelmoementrabelsi/operateurfront ./frontend/'
                //sh 'docker push abdelmoementrabelsi/operateurfront'
            }
        }
            
        stage("Push be-i to DockerHub") {
            steps{
                // login to docker hub
                sh 'docker login -u abdelmoementrabelsi -p viscabarca123'

                // build & push spring image to  docker hub
                sh 'docker build -t abdelmoementrabelsi/operateur .'
                //sh 'docker push abdelmoementrabelsi/operateur'
            }
        }
        stage('docker compose'){
            steps{
                echo 'docker compose stage';
                sh 'docker-compose up -d';
            }
        }

        
    }
}
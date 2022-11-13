pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ghassen', credentialsId: 'Github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN CLEAN') {
      steps {
        sh 'java -version';
        sh 'mvn clean ';
      }
    }
    stage('MVN TEST') {
      steps {
        sh 'mvn test ';
      }
    }

    stage('MVN COMPILE') {
      steps {
        sh 'mvn compile ';
      }
    }
    stage('MVN DEPLOY') {
      steps {
        sh 'mvn deploy -Dmaven.test.skip=true';
      }
    }

    stage('MVN SONARCUBE') {
      steps {
        sh 'mvn package sonar:sonar -Dsonar.login=admin -Dsonar.password=Za3maettal3ou';
      }
    }

    stage("Push to DockerHub") {
      steps{
        // login to docker hub
        sh 'docker login -u saafghassen -p Za3maettal3ou'

        // build & push spring image to  docker hub
        sh 'docker build -t saafghassen/facture .'
        sh 'docker push saafghassen/facture'
        
        // build & push angular image to docker hub
        sh 'docker build -t saafghassen/facturefront ./frontend/'
        sh 'docker push saafghassen/facturefront'
      }
    }

    stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }
  }
}
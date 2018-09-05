pipeline {
  agent any
  triggers {
     pollSCM('*/1 * * * *')
  }
  stages {
    stage("Compile") {
      steps {
        sh "./gradlew compileJava"
      }
    }
    stage("Unit test") {
      steps {
        sh "./gradlew test"
      }
    }
    stage("Code coverage") {
      steps {
        sh "./gradlew jacocoTestReport"
	publishHTML (target: [
          reportDir: 'build/reports/jacoco/test/html',
          reportFiles: 'index.html',
          reportName: "JaCoCo Report"
        ])
        sh "./gradlew jacocoTestCoverageVerification"
      }
    }
    stage("Static code analysis") {
      steps {
        sh "./gradlew checkstyleMain"
      }
    }
  }
  post {
    always {
      publishHTML (target: [
        reportDir: 'build/reports/checkstyle/',
        reportFiles: 'main.html',
        reportName: "Checkstyle Report"
      ])
      mail to: 'mehrtuerertrom@gmail.com',
      subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
      body: "Your build completed, please check: ${env.BUILD_URL}"
    }
  }
}

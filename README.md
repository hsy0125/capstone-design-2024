캡스톤 디자인1 2024 - 공유대학 

# 길찾는 알고리즘 만들고 안드로이드 스튜디오에서 동작하기
### 파이썬으로 현재 작성한 코드를 자바로 변환한 다음 안드로이드 스튜디오에서 동작해야함

## gradle sync 문제 해결하기!
### 문제 1. gralde sync project 버튼이 보이지 않음 -> 안드로이드 스튜디오에서 gralde을 지우고 최신 버전으로 다운받음
### 문제 2. activity_main.kts에서 gradle sync가 맞지 않고 오류메시지가 계속 뜸 -> 터미널에서 ./gradlew clean 실행
#### gradle을 지운 후 Android Studio에서 Build > Rebuild Project를 선택하여 프로젝트를 다시 빌드
#### activity_main.xml 수정 후 Gradle Sync를 다시 실행하여 종속성 및 리소스를 새로 다운로드합니다.
#### File > Sync Project with Gradle Files를 선택하거나, 툴바에서 Sync Project with Gradle Files 버튼을 클릭

### 문제 3. e: file:///C:/Users/hsy/Desktop/cap/MyNavigationApp/app/src/test/java/com/example/navigation/ExampleUnitTest.kt:3:12 Unresolved reference: junit
####  JUnit 라이브러리가 프로젝트에서 인식되지 않아서 발생하는 문제입니다. 이 문제를 해결하려면 JUnit 라이브러리를 build.gradle 파일에 추가해야 합니다.
#### build.gradle.kts 수정: testImplementation 추가: app/build.gradle.kts 파일의 dependencies 블록에 아래 라인을 추가합니다:
#### Build > Rebuild Project


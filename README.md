# BeanQuiz

BeanQuiz is a command-line interface (CLI) quiz game that tests your knowledge about various types of beans. It allows users to login, participate in quizzes and view their rank.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction

BeanQuiz is a Java application designed to provide users with an interactive quiz experience. The frontend (FE) of the application is developed using Java and utilizes Scanner and a command-line handler for user interaction. The application makes API calls to retrieve quiz questions and options using UniRest. The FE is constructed based on a factory pattern to manage the creation of quiz objects efficiently.

On the backend (BE), BeanQuiz is powered by a Spring Boot application. Spring Boot simplifies the development of Java-based applications by providing a comprehensive framework for building robust and scalable applications. The backend handles the logic for retrieving quiz data, processing user responses, and managing the application's business logic.

To ensure security measures, BeanQuiz integrates Auth0 for user authentication and registration. Auth0 provides secure authentication and authorization mechanisms, safeguarding user data and preventing unauthorized access to the application.

With its frontend and backend components seamlessly integrated, BeanQuiz offers users an engaging quiz experience while maintaining high levels of security and reliability. Whether you're a quiz enthusiast or a developer looking to explore Java application development with Spring Boot, BeanQuiz provides an intuitive and feature-rich platform for quiz-based learning and entertainment.

## Features

- User registration and login with Auth0
- Profile Customization
- Multiple quiz options with questions about various types of beans
- Interactive CLI interface for answering quiz questions
- Score tracking and quiz results

## Installation

To install BeanQuiz, follow these steps:

1. Clone the BeanQuiz repository from GitHub:

```bash
git clone git@github.com:BeanQuiz/BeanQuiz.git
```

2. Navigate to the project directory:

```bash
cd BeanQuizCli
```

3. Build the project using Maven:

```bash
mvn clean install
```

4. Run the application:

```bash
java -jar target/BeanQuizCli.jar
```

## Usage

After installing BeanQuiz, you can use the following commands to interact with the application:

- `L - Login`: Register a new user account or log in to an existing user account.
- `T - Take Quiz`: Choose a quiz to take and answer questions to test your knowledge about beans.
- `Q - Quit`: Log out of the current user account.

## Documentation

- [Jira](https://bbdnet-candle-stock-system.atlassian.net/jira/software/projects/BQ/boards/2)
- [Confluence](https://bbdnet-candle-stock-system.atlassian.net/jira/software/projects/BQ/pages)

## Contributing

Contributions to BeanQuiz are welcome! To contribute, please follow these guidelines:

- Report any issues or bugs by creating a GitHub issue.
- Submit feature requests or suggestions for improvement.

## License

BeanQuiz is licensed under the ... free license. Feel free to use, modify, and distribute the software according to the terms of the license.

## Acknowledgements

Special thanks to the contributors and developers who have contributed to BeanQuiz. Your efforts are greatly appreciated!
@Anza Mugwabana
@Christine Olckers
@Janro Botha
@Keaton Naidoo
@McQuile Karappen
@Sasha-Lee Kingwill

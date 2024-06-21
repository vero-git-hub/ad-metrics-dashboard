# Ad Metrics Dashboard

Ad Metrics Dashboard is a web application designed to visualize advertising performance metrics. It includes a React frontend with a TypeScript-based dashboard that displays metrics in a bar chart and a Spring Boot backend providing the data through a RESTful API.

## Features

- **Frontend**: Built with React and TypeScript.
    - Displays a dashboard with ad performance metrics in a bar chart.
    - Allows sorting and filtering of data.
    - Includes navigation between Home, About, and Dashboard pages.

- **Backend**: Built with Java and Spring Boot.
    - Provides a RESTful API for fetching advertising data.
    - Uses mock data for simplicity.
    - Includes unit tests for checking functionality.

## Getting Started

### Technologies

- Node.js - version 20.14.0
- npm - version 10.8.1
- Java Oracle OpenJDK - version 21.0.1
- Typescript - version 4.9.5

### Installation
1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/ad-metrics-dashboard.git
   cd ad-metrics-dashboard
   
2. Backend:
- Navigate to the backend directory:

    ```bash
    cd backend

- Build and run the Spring Boot application
    ```bash
    mvn clean install
    mvn spring-boot:run

 - The backend server will start on http://localhost:8080.

3. Frontend:
- Navigate to the frontend directory:

  ```bash
  cd ../frontend

- Install dependencies:

    ```bash
    npm install

- Start the React application:

    ```bash
    npm start
  
- The frontend server will start on http://localhost:3000.

## Usage
1. Open your browser and navigate to http://localhost:3000.
2. Use the navigation bar to switch between Home, About, and Dashboard pages.
3. On the Dashboard page, you can:
   - View ad performance metrics in a bar chart.
   - Sort the data by campaign name, impressions, or clicks using the dropdown menu.
   - Filter the data by entering a minimum number of impressions.

You can check the functionality of the application without launching the frontend, through Postman ("http://localhost:8080/api/ad-performance") or through unit tests.

## Contributing
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes.
4. Submit a pull request.

## License
This project is licensed under the MIT License.
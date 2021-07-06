import axios from "axios";

export const getAllStudents = () =>
    axios.get('http://localhost:8080/api/v1/students')
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
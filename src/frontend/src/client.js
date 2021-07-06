import axios from "axios";

const instance = axios.create({
  baseURL: "/api/v1/students",
});

export default instance;

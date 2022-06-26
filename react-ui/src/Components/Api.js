import axios from "axios"

const endpoint = 'http://localhost:8080'



const login = (data) => {
   axios.defaults.withCredentials = true;
   let userData = new URLSearchParams(data);

   return axios.post(endpoint + '/login', userData, {
      headers: { "Content-type": "application/x-www-form-urlencoded" },
   })
}
const createUser = (data) => {
   return axios.post(endpoint, data)
}
const deleteUser = (data) => {
   return axios.delete(endpoint, data)
}


export { createUser, deleteUser, login }

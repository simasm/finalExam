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

const getLoggedUser =  async () => {
   return axios.get(endpoint + '/api/loggedUser')
}

const getBooks = () => {
   return axios.get(endpoint + '/api/book/findall')
}
const createBook = (data) => {
   return axios.post(endpoint + '/api/book/new', data)
}

const logout = () => {
   
   return axios.post(endpoint + '/logout')
}

export { createUser as apiCreateUser,
    deleteUser as apiDeleteUser,
     login as apiLogin,
      getLoggedUser as apiGetLoggedUser,
      logout as apiLogout,
     createBook as apiCreateBook,
   getBooks as apiGetAllBooks }

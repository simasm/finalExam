import axios from "axios"
 
    const endpoint = 'http://localhost:8080'

  

    const createUser = (data) => {
       return axios.post(endpoint , data)
    }
    const deleteUser = (data) => {
        return axios.delete(endpoint , data)
     }

 
export {createUser,deleteUser}

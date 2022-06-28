import { useEffect, useState } from "react"
import { Container } from "react-bootstrap"
import Books from './Books'
import {apiGetAllBooks} from './Api'


const BookContainer = () => {

    const [state, setState] = useState({data : []})

    useEffect( () => {
        apiGetAllBooks().then(response => {
            setState({data : response.data})
            console.log(response.data)
        })
    },[])

   if(state.data != null)
    return (<Container><Books state={state} /></Container>)

    return (<></>)
}

export default BookContainer
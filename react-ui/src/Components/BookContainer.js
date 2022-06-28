import { useEffect, useState } from "react"
import { Container } from "react-bootstrap"
import Books from './Books'
import {apiGetAllBooks} from './Api'


const BookContainer = () => {

    const [state, setState] = useState({data : []})

    apiGetAllBooks().then(response => {
        setState({data : response.data})
    })
    return (<Container><Books state={state} /></Container>)

}

export default BookContainer
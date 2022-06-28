import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import AdminPage from './AdminPage'
import { apiCreateBook } from './Api'
const AdminContainer = () => {

    const [state, setState] = useState({ pavadinimas: '',santrauka: '',puslapiusk :'' , kategorija : '' , isbn : ''})
    const [state1, setState1] =useState({ val1: '',val2: ''  })
    const sumbitHandler = (e) => {
        e.preventDefault()

    }
    const sumbitHandler1 = (e) => {
        e.preventDefault()
        apiCreateBook({name : state.pavadinimas,
        categoryName : state.kategorija,
    description : state.santrauka,
pages : state.puslapiusk,
isbn : state.isbn});
    }
    const onChange = (e) => {
        e.preventDefault()
        if(e.target.id == "pav")
        setState({...state, pavadinimas: e.target.value })
        if(e.target.id == "san")
        setState({...state, santrauka: e.target.value })
        if(e.target.id == "psl")
        setState({...state, puslapiusk: e.target.value })
        if(e.target.id == "kat")
        setState({...state, kategorija: e.target.value })
        if(e.target.id == "isbn")
        setState({...state, isbn: e.target.value })
      
    }
    const onChange1 = (e) => {
        e.preventDefault()
        setState1({ val: e.target.value })
        console.log(e.target.id)
    }

    return (
        <Container>

            <AdminPage sumbitHandler={sumbitHandler1}
                onChange={onChange}
                state={state} />
            
        </Container>
    )
}

export default AdminContainer
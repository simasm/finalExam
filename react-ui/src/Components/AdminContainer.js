import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import AdminPage from './AdminPage'
const AdminContainer = () => {

    const [state, setState] = useState({ val1: '',val2: ''  })
    const [state1, setState1] =useState({ val1: '',val2: ''  })
    const sumbitHandler = (e) => {
        e.preventDefault()
    }
    const sumbitHandler1 = (e) => {
        e.preventDefault()
    }
    const onChange = (e) => {
        e.preventDefault()
        setState({ val: e.target.value })
        console.log(e.target.id)
    }
    const onChange1 = (e) => {
        e.preventDefault()
        setState1({ val: e.target.value })
        console.log(e.target.id)
    }

    return (
        <Container>

            <AdminPage sumbitHandler={sumbitHandler}
                onChange={onChange}
                state={state} />
            <AdminPage sumbitHandler={sumbitHandler1}
                onChange={onChange1}
                state={state1} />

        </Container>
    )
}

export default AdminContainer
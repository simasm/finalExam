import React, { useContext } from "react"
import { useNavigate } from "react-router-dom" 
import { useState } from "react"
 import { Form, Col, Button, Container, Row } from 'react-bootstrap'
import Card from 'react-bootstrap/Card'

import { createUser, login } from "../Api"
import AuthContext from "../AuthContext"


const LoginPage = () => {
    const [state, setState] = useState({
        username: '',
        password: '',
        loading: false
    })

    const navigate = useNavigate();

    const clearForm = () => {

        setState({
            ...state, user: '',
            password: null,
        })
    }
    const { setAppState } = useContext(AuthContext)
    const sumbitHandler = (e) => {
        setAppState({ type: "LOADING", value: true })
        var a = state.user;


        e.preventDefault();
        console.log(state)
        login({ username: state.username, password: state.password })
            .then(response => {
                clearForm()
                console.log("loggedin")
                navigate("/home", {replace : true})
            })

        clearForm()

    }

    const onChangeUser = ({ target: { value } }) => setState({ ...state, username: value })
    const onChangePassword = ({ target: { value } }) => setState({ ...state, password: value })


    return (

        <div>
            <Container  >
                <Row className="justify-content-md-center mt-3">
                    <Col md="auto">
                        <Card border="primary" style={{ width: '18rem' }} >
                            <Container  >

                                <Form onSubmit={sumbitHandler}>
                                    <Form.Group className="mb-3" controlId="formBasicEmail">
                                        <Form.Label>Email address</Form.Label>
                                        <Form.Control
                                            onChange={onChangeUser}
                                            type="text"
                                            placeholder="Enter email"
                                            value={state.username} />
                                        <Form.Text className="text-muted">
                                            We'll never share your email with anyone else.
                                        </Form.Text>
                                    </Form.Group>

                                    <Form.Group className="mb-3" controlId="formBasicPassword">
                                        <Form.Label>Password</Form.Label>
                                        <Form.Control
                                            type="password"
                                            placeholder="Password"
                                            onChange={onChangePassword} />
                                    </Form.Group>

                                    <Button variant="primary" type="submit" className="mb-3">
                                        Submit
                                    </Button>
                                </Form>
                            </Container>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}


export default LoginPage
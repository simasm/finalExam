import React, { useContext } from "react"
import { useState } from "react"
import Loading from "../Loading"
import { Form, Col, Button, Container, Row } from 'react-bootstrap'
import Card from 'react-bootstrap/Card'

import { createUser } from "../Api"
import AuthContext from "../AuthContext"


const LoginPage = () => {
    const [state, setState] = useState({
        user: '',
        password: null,
        loading: false
    })

    const {setAppState} = useContext(AuthContext)
    const sumbitHandler = (e) => {
        setAppState({type :"LOADING"})
        var a = state.user;
        setState({
            ...state, user: '',
            password: null,
        })
       
        e.preventDefault();
        console.log(state)
        createUser({ name: a })
            .then(response => console.log(response))
    }

    const onChange = ({ target: { value } }) => setState({ ...state, user: value })

    if (!state.loading) {
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
                                                onChange={onChange}
                                                type="text"
                                                placeholder="Enter email"
                                                value={state.user} />
                                            <Form.Text className="text-muted">
                                                We'll never share your email with anyone else.
                                            </Form.Text>
                                        </Form.Group>

                                        <Form.Group className="mb-3" controlId="formBasicPassword">
                                            <Form.Label>Password</Form.Label>
                                            <Form.Control type="password" placeholder="Password" />
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
    else return <Loading></Loading>
}
export default LoginPage
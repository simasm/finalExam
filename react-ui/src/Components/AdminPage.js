import React from "react";
import { Form, Button, Container, Row, Col, Card } from "react-bootstrap";

const AdminPage = ({ sumbitHandler, onChange, state }) => {


    return (
       
        <Container>

            <Form onSubmit={sumbitHandler}>
                <Row className="justify-content-md-left">
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="formBasicText">
                            <Form.Label> asd</Form.Label>
                            <Form.Control
                                onChange={onChange}
                                type="textarea"
                                placeholder="Enter"
                                value={state.val} />
                            <Form.Text className="text-muted">
                              asdasd
                            </Form.Text>
                        </Form.Group>
                    </Col>
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="formBasicText2">
                            <Form.Label> as</Form.Label>
                            <Form.Control
                                type="textarea"
                                placeholder="text"
                                onChange={onChange} />
                        </Form.Group>
                    </Col>



                </Row>
                <Row className="justify-content-mdl-center">
                    <Col className="col-5">
                        <Button variant="primary" type="submit" className="mb-3">
                            Submit
                        </Button>
                    </Col>
                </Row>
            </Form>
           
        </Container>
    )
}
export default AdminPage
import React from "react";
import { Form, Button, Container, Row, Col, Card } from "react-bootstrap";

const AdminPage = ({ sumbitHandler, onChange, state }) => {


    return (
       
        <Container>

            <Form onSubmit={sumbitHandler}>
                <Row className="justify-content-md-left">
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="pav">
                            <Form.Label> Knygos pavadinimas</Form.Label>
                            <Form.Control
                                onChange={onChange}
                                type="textarea"
                                placeholder="Enter"
                                value={state.val} />
                            
                        </Form.Group>
                    </Col>
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="san">
                            <Form.Label> Santrauka</Form.Label>
                            <Form.Control
                                type="textarea"
                                placeholder="text"
                                onChange={onChange} />
                        </Form.Group>
                    </Col>
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="psl">
                            <Form.Label> Puslapiu skaicius</Form.Label>
                            <Form.Control
                                type="textarea"
                                placeholder="text"
                                onChange={onChange} />
                        </Form.Group>
                    </Col>
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="kat">
                            <Form.Label> Kategorija</Form.Label>
                            <Form.Control
                                type="textarea"
                                placeholder="text"
                                onChange={onChange} />
                        </Form.Group>
                    </Col>
                    <Col className="col-3">
                        <Form.Group className="mb-3" controlId="isbn">
                            <Form.Label> isbn</Form.Label>
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
                            Sukurti knyga
                        </Button>
                    </Col>
                </Row>
            </Form>
           
        </Container>
    )
}
export default AdminPage
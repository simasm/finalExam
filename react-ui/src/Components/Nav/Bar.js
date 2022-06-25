import { React } from 'react'
import { Navbar, Nav, NavDropdown, Container } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const Bar = () => {


    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand as={Link} to="/">Bar</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link as={Link} to="/home">Home</Nav.Link>
                        <Nav.Link as={Link} to="/link1">Link1</Nav.Link>
                        <Nav.Link as={Link} to="/link1">Link2</Nav.Link>
                        <NavDropdown title="Dropdown" id="collasible-nav-dropdown">
                            <NavDropdown.Item as={Link} to="/asd">Action</NavDropdown.Item>
                            <NavDropdown.Item as={Link} to="/link2">Another action</NavDropdown.Item>
                            <NavDropdown.Item as={Link} to="/link2">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item as={Link} to="/link2">Separated link</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link as={Link} to="/login">login</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </div>

    );
}

export default Bar
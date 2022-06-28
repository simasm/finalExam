import { React, useContext } from 'react'
import { Navbar, Nav, NavDropdown, Container, Button } from 'react-bootstrap'
import { Link, Navigate, useNavigate } from 'react-router-dom'
import AuthContext from '../AuthContext'
 import { apiLogout } from '../Api'
const Bar =  () => {

    const {appState,setAppState} = useContext(AuthContext)
    const navigate = useNavigate()
    const logoutHandler = async () => {

        return apiLogout().then(response => {
          setAppState({ type: "LOGOUT" })
          navigate("/login", {replace : true})
         })
    }

    return (
        <div>
            <Navbar bg="dark" variant="dark" className="me-5">
                <Container>
                    <Navbar.Brand as={Link} to="/">Knygos</Navbar.Brand>
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

                        <Nav.Link as={Link} to="/admin"
                       className={appState.isAuthenticated ? "btn btn-secondary me-3" : ""} >admin</Nav.Link>

                     
                    </Nav>
                    <Nav >
                        <Nav.Link as={Button} onClick={logoutHandler}>logout</Nav.Link>
                        </Nav>
                </Container>
            </Navbar>
        </div>

    );
}

export default Bar
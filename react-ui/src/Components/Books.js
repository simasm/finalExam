import { Button, Card, Container } from "react-bootstrap"

const Books = () => {




    return (<Container>
        <Card className="mt-5" style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>
                    knyga
                </Card.Title>
                <Card.Text>
                    knyga1
                </Card.Text>
                <Button variant="primary"> click </Button >
            </Card.Body>
        </Card>
    </Container>)
}

export default Books
import { Button, Card, Container } from "react-bootstrap"

const Books = ({state}) => {




    return (<Container>
        {state.map( book =>  {
        <Card key = {book.id} className="mt-5" style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>
                    {book.name}
                </Card.Title>
                <Card.Text>
                    {book.description}
                </Card.Text>
                <Button variant="primary"> click </Button >
            </Card.Body>
        </Card>
        })
    }
    </Container>)
}

export default Books
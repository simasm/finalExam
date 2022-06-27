import { Spinner,Container } from "react-bootstrap"


const Loading = ({visible}) => {
    if(visible)
    return (
        <Spinner animation="border" className="float-end" />
    )
    else
    return (<></>)
}

export default Loading
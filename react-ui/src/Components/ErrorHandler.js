
import React, { useContext } from 'react'
import axios from 'axios'
import Loading from './Loading';
import AuthContext from './AuthContext';

const ErrorHandler = ({ children }) => {

    const { setAppState } = useContext(AuthContext)

    React.useMemo(() => {
        axios.interceptors.response.use(response => {
            console.log("res")


            setAppState({ type: "LOADING" })
            return response

        }, async (error) => {
            console.log("err")

            const expectedError = error.response && error.response.status >= 400 && error.response.status < 500;
            if (!expectedError) {
                alert('Įvyko klaida, puslapis nurodytu adresu nepasiekiamas');

            } else if (error.response.status === 401) {
                alert('Neprisijungta')

            } else if (error.response.status === 403) {
                alert('Prieiga uždrausta')

            }
            else return Promise.reject(error);

        });

    }, [setAppState])
    return children;
}

export default ErrorHandler

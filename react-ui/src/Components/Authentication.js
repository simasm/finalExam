import React, { useContext, useEffect, useState } from 'react'
import { useLocation, Navigate, useNavigate } from 'react-router-dom';
import AuthContext from './AuthContext';
import { apiGetLoggedUser } from './Api'
const Authentication = ({ children }) => {

    const { appState, setAppState } = useContext(AuthContext)
    useEffect(() => {
        const fetchAuth = () => {
            apiGetLoggedUser().then(response => {
                if (response && response.status === 200)
                    setAppState({ type: "AUTHENTICATED" })
            })
        }
        fetchAuth()

    }, [setAppState])
    let location = useLocation()

    if (!appState.isAuthenticated) {

        return (<React.Fragment><Navigate to="/login" state={{ from: location }} replace /></React.Fragment>);
    }


    return (<React.Fragment> {children} </React.Fragment>)
}

export default Authentication
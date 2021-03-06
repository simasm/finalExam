import Bar from './Components/Nav/Bar';
import {
  BrowserRouter,
  Routes,
  Route,
  Navigate,
  useNavigate
} from 'react-router-dom';

import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Link1 from './Components/Links/Link1';
import Home from './Components/Home';
import LoginPage from './Components/Nav/LoginPage';
import Loading from './Components/Loading';
import ErrorHandler from './Components/ErrorHandler'

import AuthContext from './Components/AuthContext';
import { useReducer } from 'react';
import AdminContainer from './Components/AdminContainer';
import Authentication from './Components/Authentication';
import { apiLogout } from './Components/Api'

function App() {

  var initState = {
    isAuthenticated: false,
    username: null,
    role: null,
    isLoading: false,
   }

  const auth = (appState, action) => {
    switch (action.type) {
      case "LOGIN":
        return {
          ...appState,
          isAuthenticated: true,
          username: action.value.username,
          role: action.value.role
        }
      case "LOGOUT":
        return {
          ...appState,
          isAuthenticated: false,
          username: null,
          role: null,
         }
      case "LOADING":
        return {
          ...appState,
          isLoading: action.value
        }
      case "AUTHENTICATED":
        return {
          ...appState,
          isAuthenticated: true
        }
      default:
        return appState
    }
  }
  const [appState, setAppState] = useReducer(auth, initState)



   
  return (

    <div className="container">
      <div className='App'>
        <AuthContext.Provider value={{ appState, setAppState }}>
          <ErrorHandler>

            <BrowserRouter>
              {appState.isLoading ? <Loading visible={true}/> : <Loading visible={false}/>}

              <Bar />
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/home" element={<Home />} />
                <Route path="/link1" element={<Link1 />} />
                <Route path="/link2" element={<Link1 />} />
                <Route path="/login" element={<LoginPage />} />
                <Route exact path="/admin" element={
                  <Authentication>
                    <AdminContainer />
                  </Authentication>
                } />



                <Route
                  path="*"
                  element={
                    <main style={{ padding: "1rem" }}>
                      <p>Puslapio n??ras</p>
                    </main>
                  }
                />
              </Routes>

            </BrowserRouter>
          </ErrorHandler>

        </AuthContext.Provider>

      </div>
    </div >
  );
}

export default App;

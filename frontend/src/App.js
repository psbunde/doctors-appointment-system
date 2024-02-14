import { Link, Route ,Routes ,useNavigate} from 'react-router-dom';
import './App.css';
import LoginComp from './components/LoginComp';
import HomeComp from './components/HomeComp';
import PatientHomeComp from './components/PatientHomeComp';
import LogoutComp from './components/LogoutComp';
import PatientRegistrationComp from './components/PatientRegistrationComp';
import { useSelector } from 'react-redux';
import { useState, useEffect } from 'react';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import ViewPatientComp from './components/ViewPatientComp';
import ContactUsComp from './components/ContactUsComp';
import AboutUsComp from './components/AboutUsComp';
import ForgetPasswordComp from './components/ForgetPasswordComp';
import ChangePasswordComp from './components/ChangePasswordComp';

function App() {

  const mystate = useSelector((state)=>state.logged);

  const[depts,setDepts]=useState([]);
  const[dname,setDname]=useState("");
  const navigate= useNavigate();
  
  //get all departments on loading of homepage/app.js for dropdown of departments
  useEffect(()=>{
    fetch("http://localhost:8080/getAllDepartments")
    .then((resp)=>resp.json())
    .then((deptlist)=>setDepts(deptlist))
  },[])

  //set dept name to display doctors departtment wise
  const handleSelect=event=>{
        localStorage.setItem("dname",dname);
        navigate("/doctorDept");
  }

  return (
    <div className="App">
     
        <h1 className="bg-info text-blue">LifeLine Hospital</h1>

      <div style={{display: mystate.loggedIn ? "none" : "block" }}>     
          <nav className="navbar navbar-expand-sm bg-light mb-3">
            <div  className="container-fluid">
                <ul className="navbar-nav">
                    <li className="nav-item">
                      <Link to="/" className="nav-link px-3">Home</Link>
                    </li>
                    <li className="nav-item">
                      <Link to="aboutus" className="nav-link px-3">About us</Link>
                    </li>
                    <li className="nav-item">
                      <Link to="viewDoctors" className="nav-link px-3">Doctors</Link>
                    </li>
                    <li className="nav-item">
                    <DropdownButton variant="none"
                          alignright
                          title="Departments"
                          id="dropdown-menu-align-right"
                            >
                              {
                                depts.map((dept) => {
                                  return <Dropdown.Item onMouseDown={(e)=>{setDname(e.target.innerHTML)}} 
                                                        onMouseUp={handleSelect}>{dept}</Dropdown.Item>
                                })
                              }
                     </DropdownButton>
                     {/*       
                      <select onChange={handleSelect}>
                        <option>Departments</option>
                        {
                          depts.map(dept => {
                          return <option value={dept}>{dept}</option>
                          })
                        }
                      </select>
                      */}
                          
                    </li>
                    <li className="nav-item">
                      <Link to="patientRegistration" className="nav-link px-3">Patient Registration</Link>
                    </li>
                    <li className="nav-item">
                      <Link to="contactus" className="nav-link px-3">Contact us</Link>
                    </li>
                    <li className="nav-item">
                      <Link to="login" className="nav-link px-3">Login</Link>
                    </li>
                </ul>
            </div>
          </nav>

          {/*JSON.stringify(depts)*/}

        
      </div>
      <Routes>
          <Route path="/" element={<HomeComp/>}  />
          <Route path="/login" element={<LoginComp/>}  />
          <Route path="/patienthome" element={<PatientHomeComp/>}>
              
          </Route>
          <Route path="/logout" element={<LogoutComp/>}  />
          <Route path="/patientRegistration" element={<PatientRegistrationComp/>}  />
          <Route path="/contactus" element={<ContactUsComp/>}/> 
          <Route path="/aboutus" element={<AboutUsComp/>}/> 
          <Route path="/forgetPassword" element={<ForgetPasswordComp/>}/> 
          <Route path="/changePassword" element={<ChangePasswordComp/>}/>

      </Routes>
      
    </div>
  );
}

export default App;

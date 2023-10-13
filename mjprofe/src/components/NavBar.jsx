import { Link } from "react-router-dom";
import mjpro from "../assets/mjpro_image.jpg"

export default function NavBar() {
    return <nav className="nav">
        <h1 className="siteTitle"><Link to="/"><img className="logo" src={mjpro} alt="logo"></img></Link></h1>
        
        <ul>
            <li><Link to="/register">Vendor Registration</Link></li>
            <li><Link to="/contact">Contact</Link></li>
            <li><Link to="/about">About</Link></li>
        </ul>
    </nav>
}
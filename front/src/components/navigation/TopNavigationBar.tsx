import { Link } from 'react-router-dom';
import './TopNavigationBar.scss';

export const TopNavigationBar = () => {
  return (
    <>
      <div className="top-navigation-bar-wrapper">
        <div className="logo">
          <Link to="/" className="logo-link">
            Kiwi docs
          </Link>
        </div>
        <div>
          <Link to="/login" className="link mr-4">
            Login
          </Link>
          <Link to="/signup" className="link">
            Sign Up
          </Link>
        </div>
      </div>
    </>
  );
};

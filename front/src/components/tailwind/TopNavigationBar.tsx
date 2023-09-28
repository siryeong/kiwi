import { Link } from 'react-router-dom';

export const TopNavigationBar = () => {
  return (
    <>
      <div className="flex justify-between items-center bg-sky-500 p-3">
        <div className="flex items-center">
          <Link to="/" className="text-white text-lg">
            Kiwi docs
          </Link>
        </div>
        <div>
          <Link to="/login" className="text-white mr-4 hover:underline">
            Login
          </Link>
          <Link to="/signup" className="text-white hover:underline">
            Sign Up
          </Link>
        </div>
      </div>
    </>
  );
};

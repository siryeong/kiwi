import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <>
      <div className="py-24">
        <div className="container mx-auto md:w-1/2">
          <div className="bg-white p-8 rounded-lg shadow-md">
            <h2 className="text-2xl font-semibold mb-2">Kiwi</h2>
            <p className="text-gray-600">키위에 오신 것을 환영합니다.</p>
            <p className="mt-4 text-center">
              <Link to="/signup" className="text-blue-500 hover:underline">
                시작하기
              </Link>
            </p>
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;

import { Header } from '@/components/layout/Header.tsx';
import { Footer } from '@/components/layout/Footer.tsx';
import { Outlet } from 'react-router-dom';

export const HomeLayout = () => {
  return (
    <div>
      <Header />
      <main>
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};

export default HomeLayout;

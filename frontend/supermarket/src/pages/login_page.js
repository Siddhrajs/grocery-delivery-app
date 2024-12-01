import BrandHeader from "../components/brand_header";
import LoginForm from "../components/login_form";
function LoginPage() {
  return <div className="bg-black h-screen w-screen">
    <BrandHeader />
    <div className="h-10" />
    <LoginForm/>
  </div>;
}

export default LoginPage;

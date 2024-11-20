import BrandHeader from "../components/brand_header";
import LoginForm from "../components/login_form";
import Spacer from "../components/utils/spacer";
function LoginPage() {
  return <div className="bg-black h-screen w-screen">
    <BrandHeader />
    <Spacer className="h-10" />
    <LoginForm className/>
  </div>;
}

export default LoginPage;

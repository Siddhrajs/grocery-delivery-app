import PrimaryButton from "./utils/primary_button";
import SecondaryButton from "./utils/secondary_button";
import SMInput from "./utils/sm_input";
import GoogleIcon from "../assets/google_icon.svg";

function LoginForm({ className }) {
    const googleIcon = {
        src: GoogleIcon,
        alt: "Google Icon"
    }

    const handleLogin = () => {
        console.log("Login button clicked");
    }
    
    const handleGoogleLogin = () => {
        window.location.href = 'http://localhost:8080/oauth2/authorization/google';
    }

  return (
    <div className={`flex flex-col items-start justify-center ${className}`}>
        <div className="text-3xl font-regular">Login</div>
        <hr className="w-7 border-t-2 my-4 border-black" />
        <form className="w-3/5">
            <SMInput id="email" label="Email" type="email"/>
            <SMInput className="mb-4" id="password" label="Password" type="password"/>
            <PrimaryButton className="w-full h-12 text-sm" id="login-button" label="LOGIN" onClick={handleLogin}/>
        </form>
        <hr className="w-3/5 my-4 border-gray-300" />
        <SecondaryButton className="w-3/5 text-sm h-12" id="google-login" icon={googleIcon} label="LOGIN WITH GOOGLE" onClick={handleGoogleLogin}/>
    </div>
  )
}

export default LoginForm;

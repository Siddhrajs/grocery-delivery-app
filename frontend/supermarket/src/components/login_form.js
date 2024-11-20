import PrimaryButton from "./utils/primary_button";
import SecondaryButton from "./utils/secondary_button";
import SectionSeparator from "./utils/section_separator";
import Spacer from "./utils/spacer";
import StyledInput from "./utils/styled_input";
import GoogleIcon from "../assets/google_icon.svg";

function LoginForm() {
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
    <div className="flex flex-col items-center justify-center">
        <div className="flex flex-col items-center justify-center bg-[#232222] rounded-lg p-10">
            <span className="text-2xl font-bold text-white">Sign in</span>
            <Spacer className="h-6" />
            <StyledInput label="Email" type="email" placeholder="Your Email Address" />
            <StyledInput label="Password" type="password" placeholder="********" />
            <Spacer className="h-2" />
            <PrimaryButton id="login-button" label="Continue" onClick={handleLogin}/>
            <SectionSeparator />
            <SecondaryButton id="google-login" icon={googleIcon} label="Continue with Google" onClick={handleGoogleLogin}/>
        </div>
    </div>
  )
}

export default LoginForm;

function StyledInput({ className, placeholder, type, label }) {
  return (
    <div className={"flex flex-col items-start justify-center px-4"+className}>
                <span className="text-sm text-white">{label}</span>
                <input type={type} className="w-full py-2 px-4 bg-transparent border border-[#828282] hover:border-[#959AF9] focus:border-[#959AF9] focus:border-2 cursor-text text-white focus:outline-none rounded-md my-2 placeholder:text-[#828282] placeholder:text-sm" placeholder={placeholder} />
    </div>
  );
}

export default StyledInput;

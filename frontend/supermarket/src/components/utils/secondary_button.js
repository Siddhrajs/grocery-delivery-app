function SecondaryButton({ icon, label, id, onClick, className }) {
  return (
    <button id={id} className={`w-full py-2 px-4 bg-black text-white flex font-roboto font-semibold hover:shadow-lg items-center justify-start ${className}`} onClick={onClick}>
      <img src={icon.src} alt={icon.alt} className="w-4 h-4 mr-2 align-start" />
      <span className="flex-1">{label}</span>
    </button>
  );
}

export default SecondaryButton;

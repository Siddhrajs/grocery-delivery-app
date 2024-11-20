function PrimaryButton({ label, id, onClick }) {
  return <button id={id} className="w-full py-2 px-4 bg-white text-black hover:bg-[#959AF9] hover:text-white rounded-md" onClick={onClick}>{label}</button>;
}

export default PrimaryButton;

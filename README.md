# NFA-Simulation-Multiple-Next-States

## **📌 Overview**
<div style="text-align: justify;">
LabActivity2_NFA is a Java program that simulates a Non-Deterministic Finite Automaton (NFA) designed to check whether a given string over {a, b} is accepted or rejected based on multiple possible transitions between states.It runs interactively in the terminal and allows users to test multiple strings until they choose to exit.
This NFA accepts strings that contain the substring “ab”.
 </div>

 ## **⚙️ How It Works**
     The NFA has three states: q0 → q1 → q2
     - Start state: q0
     - Accepting (final) state: q2

## 🔁 **Transition Table**
| **Current State** | **Input = a** | **Input = b** |
|--------------------|---------------|---------------|
| `q0` *(start)* | `{q0, q1}` | `{q0}` |
| `q1` | `{q0, q1}` | `{q0, q2}` |
| `q2` *(final)* | `{q2}` | `{q2}` |

**➡️ The NFA explores all possible transitions.**
- If any computation path reaches q2 (the accepting state), the string is Accepted.
Otherwise, it is Rejected.

## 🧩 **Language**
*L = { w ∈ {a, b} ∣ w contains the substring "ab" }**

**In Words:** All strings over {a, b} that contain "ab" anywhere in the sequence.

# 🧑‍💻 **Example Output**
<img width="365" height="327" alt="LabAct2_ss1" src="https://github.com/user-attachments/assets/ec81e670-4205-44e5-901b-56ec1fe61034" />


<img width="903" height="447" alt="LabAct2_ss2" src="https://github.com/user-attachments/assets/8b91bc26-9db7-4da3-8b2e-7517bdeab874" />
